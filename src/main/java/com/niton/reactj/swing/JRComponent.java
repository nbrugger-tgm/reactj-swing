package com.niton.reactj.swing;

import com.niton.reactj.Reactable;
import com.niton.reactj.ReactiveBinder;
import com.niton.reactj.ReactiveComponent;
import com.niton.reactj.mvc.ReactiveView;

import javax.swing.*;

public abstract class JRComponent<M extends Reactable> extends ReactiveView<JPanel,M> {

}
