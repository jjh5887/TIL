package me.powerarc;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

// 프로세서 자동으로 등록 -> resource/META-INF/service/javax/...Processor 필요 X
@AutoService(Processor.class)
public class MagicMojaProcessor extends AbstractProcessor {

	// 어떤 어노테이션을 처리할지
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Set.of(Magic.class.getName());
	}

	// 어떤 소스코드 버전을 지원할지
	@Override
	public SourceVersion getSupportedSourceVersion() {
		// 최신버전 (11)
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Magic.class);
		for (Element element : elementsAnnotatedWith) {
			Name elementName = element.getSimpleName();
			// 해당 element가 인터페이스인지
			if (element.getKind() != ElementKind.INTERFACE) {
				processingEnv.getMessager()
					.printMessage(Diagnostic.Kind.ERROR, "Magic annotation can not be used on " + elementName);
			} else {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing " + elementName);
			}

			TypeElement typeElement = (TypeElement)element;
			ClassName className = ClassName.get(typeElement);

			// 1. 객체 정의
			// 함수 생성
			MethodSpec pullOut = MethodSpec.methodBuilder("pullOut")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addStatement("return $S", "Rabbit!")
				.build();

			// 클래스 생성
			TypeSpec magicMoja = TypeSpec.classBuilder("MagicMoja")
				.addModifiers(Modifier.PUBLIC)
				.addSuperinterface(className)
				.addMethod(pullOut)
				.build();

			// 2. 객체 생성
			// processingEnv -> AbstractProcessor의 멤버
			Filer filer = processingEnv.getFiler();
			try {
				JavaFile.builder(className.packageName(), magicMoja)
					.build()
					.writeTo(filer);
			} catch (IOException e) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR: " + e);
			}

		}

		// true를 return하면 해당 어노테이션을 처리완료해서 다른 process에서 처리하지 않음
		return true;
	}
}
