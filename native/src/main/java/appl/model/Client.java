package appl.model;

public class Client{
    private final long id;
    private final ClientData clientData;

    public Client(long id, ClientData clientData) {
        this.id = id;
        this.clientData = clientData;
    }

    public long getId() {
        return id;
    }

    public ClientData getClientData() {
        return clientData;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientData=" + clientData +
                '}';
    }
}
