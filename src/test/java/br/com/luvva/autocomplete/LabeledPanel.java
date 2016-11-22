package br.com.luvva.autocomplete;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class LabeledPanel extends JPanel
{
    private JLabel    label;
    private Component component;

    public void setComponent (Component component, String text)
    {
        setComponent(component, text, SwingConstants.LEFT);
    }

    private void setComponent (Component component, String text, int alignment)
    {
        if (component == null)
        {
            throw new NullPointerException();
        }
        this.component = component;
        String notNullText = text == null ? "" : text;
        setLayout(new BorderLayout(0, 3));
        switch (alignment)
        {
            case SwingConstants.LEADING:
            case SwingConstants.LEFT:
                label = createLabel(" " + notNullText, alignment);
                break;
            default:
                label = createLabel(notNullText, alignment);
                break;
        }
        add(label, BorderLayout.PAGE_START);
        add(component, BorderLayout.CENTER);
    }

    private JLabel createLabel (String text, int alignment)
    {
        return new JLabel(text, alignment);
    }

    public JLabel getLabel ()
    {
        return label;
    }

    @Override
    public boolean requestFocusInWindow ()
    {
        return component.requestFocusInWindow();
    }
}
