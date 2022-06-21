package me.powerarc.demospringdi.di;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class ContainerServiceTest {

	@Test
	public void getObject_TestRepository() throws
		ReflectiveOperationException {
		TestRepository testRepository = ContainerService.getObject(TestRepository.class);
		assertNotNull(testRepository);
	}

	@Test
	public void getObject_TestService() throws
		ReflectiveOperationException {
		TestService testService = ContainerService.getObject(TestService.class);
		assertNotNull(testService);
		assertNotNull(testService.testRepository);
	}
}