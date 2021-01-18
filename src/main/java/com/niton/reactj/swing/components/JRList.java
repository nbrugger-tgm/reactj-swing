package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.special.ListView;
import com.niton.reactj.special.ReactiveListView;
import com.niton.reactj.swing.JComponentExtension;

import javax.swing.*;
import java.util.Vector;

/**
 * For truly reactive lists use own classes that extend {@link ReactiveListView} or {@link ListView}
 * @param <E> same as in {@link JList}
 */
public class JRList<E> extends JList<E> implements JComponentExtension<JList<E>> {
	@Override
	public JList<E> getThis() {
		return this;
	}
	public void bindDataArray(String property, ReactiveBinder binder){
		binder.<E[]>bind(property,getThis()::setListData);
	}

	/**
	 * Use this if the property is an array
	 * @param property
	 * @param converter
	 * @param binder
	 * @param <T>
	 */
	public <T> void bindDataArray(String property, ReactiveBinder.Converter<T,E[]> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setListData,converter);
	}
	public void bindData(String property, ReactiveBinder binder){
		binder.<Vector<E>>bind(property,getThis()::setListData);
	}

	public <T> void bindData(String property, ReactiveBinder.Converter<T, Vector<E>> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setListData,converter);
	}

}
