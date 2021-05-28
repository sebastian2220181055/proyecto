package mvc.controller;

import mvc.view.InterfaceCelular;

public class ControllerForInterface
{
    private static ControllerForInterface controllerForInterface = null;

    public static void getInstance(){

        if(controllerForInterface == null){
            new InterfaceCelular();
            ControllerForClient.getInstance(null);
        }
    }

    public static void main(String[] args) {
        getInstance();
    }
}
