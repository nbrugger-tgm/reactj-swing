package com.niton.reactj.swing.components;

import com.niton.reactj.swing.JTextComponentExtension;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class JREditorPane extends JEditorPane implements JTextComponentExtension {
	@Override
	public JTextComponent getThis() {
		return this;
	}
}
