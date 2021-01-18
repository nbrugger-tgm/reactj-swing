package com.niton.reactj.swing;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;

import javax.swing.*;
import java.awt.*;

public interface JComponentExtension<C extends JComponent> extends Modifiable<C> {

	default void bindVisibility(String property, ReactiveBinder binder){
		binder.<Boolean>bind(property, getThis()::setVisible);
	}
	default <T> void bindVisibility(String property, Converter<T,Boolean> converter,ReactiveBinder binder){
		binder.bind(property, getThis()::setVisible, converter);
	}
	default void bindOpaque(String property, ReactiveBinder binder){
		binder.<Boolean>bind(property, getThis()::setOpaque);
	}
	default <T> void bindOpaque(String property, Converter<T,Boolean> converter,ReactiveBinder binder){
		binder.bind(property, getThis()::setOpaque, converter);
	}
	default void bindWidth(String property, ReactiveBinder binder){
		binder.<Integer>bind(property,(b)->getThis().getSize().width = b);
	}
	default <T> void bindHeight(String property,ReactiveBinder binder){
		binder.<Integer>bind(property,(b)->getThis().getSize().height = b);
	}
	default void bindX(String property, ReactiveBinder binder){
		binder.<Boolean>bind(property, getThis()::setVisible);
	}
	default <T> void bindY(String property, Converter<T,Boolean> converter,ReactiveBinder binder){
		binder.<Boolean>bind(property, getThis()::setVisible);
	}
	default void bindBackground(String property, ReactiveBinder binder){
		binder.<Color>bind(property, getThis()::setBackground);
	}
	default <T> void bindBackground(String property, Converter<T, Color> converter, ReactiveBinder binder){
		binder.bind(property, getThis()::setBackground, converter);
	}
	default void bindEnabled(String property, ReactiveBinder binder){
		binder.<Boolean>bind(property, getThis()::setEnabled);
	}
	default <T> void bindEnables(String property, Converter<T,Boolean> converter,ReactiveBinder binder){
		binder.bind(property, getThis()::setEnabled, converter);
	}
	default void bindFont(String property, ReactiveBinder binder){
		binder.<Font>bind(property, getThis()::setFont);
	}
	default <T> void bindFont(String property, Converter<T,Font> converter,ReactiveBinder binder){
		binder.bind(property, getThis()::setFont, converter);
	}
	default void bindForeground(String property, ReactiveBinder binder){
		binder.<Color>bind(property, getThis()::setForeground);
	}
	default <T> void bindForeground(String property, Converter<T, Color> converter, ReactiveBinder binder){
		binder.bind(property, getThis()::setForeground, converter);
	}
}
