package myapplication.salvatop.surveyapp.model;

import java.io.Serializable;

public class InternetProvider implements Serializable {

    private String provider;
    private static int clientsCount = 1;


    public InternetProvider(String provider) {

        this.provider = provider;
    }

    public static int getClientsCount() {
        return clientsCount;
    }

    public static void setClientsCount(int clientsCount) {
        InternetProvider.clientsCount = clientsCount;
    }

    public String getInternetProvider() {
        return provider;
    }

    public void setInternetProvider(String provider) {
        this.provider = provider;
    }
}
