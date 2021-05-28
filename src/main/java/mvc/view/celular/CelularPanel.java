package mvc.view.celular;

import mvc.view.InterfaceCelular;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CelularPanel extends JPanel
{
    private BotonCelularPanel botonCelularPanel;
    private CelularInfoPanel celularInfoPanel;
    private InterfaceCelular principal;

    public CelularPanel( InterfaceCelular ventana ) {

        principal = ventana;
        setLayout(new GridLayout(1, 3));
        setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Celular")));

        celularInfoPanel = new CelularInfoPanel();
        add(celularInfoPanel);

        botonCelularPanel = new BotonCelularPanel();
        add(botonCelularPanel);
    }
}
