package chapter01.item07.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class PostRepository {
	private final Map<CacheKey, Post> cache;

	public PostRepository() {
		// key 값이 참조되지 않으면 map에서 알아서 제거
		this.cache = new WeakHashMap<>();
	}

	public Post getPostById(CacheKey key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			// TODO DB에서 읽어오거나 REST API를 통해 읽어올 수 있습니다.
			Post post = new Post();
			cache.put(key, post);
			return post;
		}
	}

	public Map<CacheKey, Post> getCache() {
		return cache;
	}
}
