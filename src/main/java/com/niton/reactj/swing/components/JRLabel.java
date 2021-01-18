package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.swing.JComponentExtension;

import javax.swing.*;

public class JRLabel extends JLabel implements JComponentExtension<JLabel> {

	public void bindText(String property, ReactiveBinder binder){
		binder.bind(property,getThis()::setText);
	}

	public <T> void bindText(String property, ReactiveBinder.Converter<T,String> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setText,converter);
	}

	@Override
	public JLabel getThis() {
		return this;
	}
}
