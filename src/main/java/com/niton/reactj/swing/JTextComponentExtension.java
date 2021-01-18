package com.niton.reactj.swing;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public interface JTextComponentExtension extends JComponentExtension<JTextComponent> {

	default void bindText(String property, ReactiveBinder binder){
		binder.bind(property,getThis()::setText);
	}

	default <T> void bindText(String property, Converter<T,String> converter, ReactiveBinder binder){
		binder.bind(property,getThis()::setText,converter);
	}


	default void biBindText(String property, ReactiveBinder binder){
		binder.bindBi(property,getThis()::setText,getThis()::getText);
		addTextChangeBinding(binder);
	}

	default  <T> void biBindText(String property, Converter<T,String> toDisplayConverter, Converter<String,T> toModelConverter, ReactiveBinder binder){
		binder.bindBi(property,getThis()::setText,getThis()::getText,toModelConverter,toDisplayConverter);
		addTextChangeBinding(binder);
	}
	default void addTextChangeBinding(ReactiveBinder binder) {
		getThis().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {binder.react();}

			@Override
			public void removeUpdate(DocumentEvent e) {binder.react();}

			@Override
			public void changedUpdate(DocumentEvent e) {
				binder.react();
			}
		});
	}


}
