package com.hddz.will.mongodb.param;

import java.util.List;

public class Page<T> {

	/**
	 * 总的页数
	 */
	public Integer count;

	/**
	 * 需要返回的list
	 */
	public List<T> lists;

	public static <V> Page<V> of(Integer count, List<V> lists) {

		Page<V> page = new Page<>();

		page.count = count;
		page.lists = lists;

		return page;
	}
}
