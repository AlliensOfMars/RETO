package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static String password() {
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();

        while(pass.length() < 8) {
            int password = (int)(rnd.nextFloat() * (float)caracteres.length());
            pass.append(caracteres.charAt(password));
        }

        String password1 = pass.toString();
        return password1;
    }

    public static String usuario(String nombre, String ap1) {
        String name=nombre.replaceAll(" ","");

        String user = new String(String.valueOf(name).concat(".").concat(ap1));
        return user;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("nombre");
        String nombre = br.readLine();
        System.out.println("ap1");
        String ap1 = br.readLine();
        System.out.println("ap2");
        String ap2 = br.readLine();
        String user = usuario(nombre, ap1);
        String pwd = password();
        System.out.println("tu usuario es: " + user + " y tu contraseña de acceso es: " + pwd);
    }
}
