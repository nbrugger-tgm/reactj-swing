package com.niton.reactj.swing;

import javax.swing.*;
import java.awt.*;

public interface Modifiable<T extends Container> {
	T getThis();
}
