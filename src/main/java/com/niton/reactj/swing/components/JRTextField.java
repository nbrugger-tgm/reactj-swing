package com.niton.reactj.swing.components;

import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveBinder.Converter;
import com.niton.reactj.swing.JComponentExtension;
import com.niton.reactj.swing.JTextComponentExtension;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class JRTextField extends JTextField implements JTextComponentExtension {
	public JRTextField(int i) {
		super(i);
	}

	public JRTextField(String text, int columns) {
		super(text, columns);
	}

	public JRTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
	}

	public JRTextField() {
	}

	public JRTextField(String text) {
		super(text);
	}

	@Override
	public JTextField getThis() {
		return this;
	}
}
