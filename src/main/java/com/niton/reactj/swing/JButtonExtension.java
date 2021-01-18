package com.niton.reactj.swing;

import com.niton.reactj.ReactiveBinder;

import javax.swing.*;

public interface JButtonExtension extends JComponentExtension<AbstractButton>{
	default <T> void bindIcon(String property, ReactiveBinder.Converter<T,Icon> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setIcon,converter);
	}
	default  <T> void bindText(String property, ReactiveBinder.Converter<T,String> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setText,converter);
	}
	default void bindText(String property, ReactiveBinder binder){
		binder.bind(property,getThis()::setText);
	}
	default  <T> void bindSelected(String property, ReactiveBinder.Converter<T,Boolean> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setSelected,converter);
	}
	default void bindSelected(String property, ReactiveBinder binder){
		binder.bind(property,getThis()::setSelected);
	}
}
