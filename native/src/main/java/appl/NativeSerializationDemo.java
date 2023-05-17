package appl;

import appl.model.Client;
import appl.model.ClientData;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NativeSerializationDemo {
    private static final Logger logger = LoggerFactory.getLogger(NativeSerializationDemo.class);

    /*
    Задание.
    Надо реализовать сериализацию и десериализацию объекта.
        Метод serialize должен объект сериализовать в ByteBuffer.
        Метод deserialize должен из ByteBuffer десериализовать объект.
    */

    public static void main(String[] args) {
        var clientData = new ClientData(17, "dataString", true, true);
        var client = new Client(1, clientData);
        logger.info("client:{}", client);
        var serialization = new NativeSerializationDemo();
        var clientAsBytes = serialization.serialize(client);
        var clientDeserialized = serialization.deserialize(clientAsBytes);
        logger.info("clientDeserialized:{}", clientDeserialized);
    }

    private ByteBuffer serialize(Client client) {
        var bytes = client.clientData().valueString().getBytes(StandardCharsets.UTF_8);
        var buffer =
                ByteBuffer.allocate(
                        Long.BYTES + Long.BYTES + Integer.BYTES + bytes.length + Long.BYTES);

        buffer.putLong(client.id());
        buffer.putLong(client.clientData().valueLong());
        buffer.putInt(bytes.length);
        buffer.put(bytes);

        var booleans = 0L;
        booleans = setBit(booleans, 0, client.clientData().valueBool1());
        booleans = setBit(booleans, 1, client.clientData().valueBool2());

        buffer.putLong(booleans);

        return buffer;
    }

    private Client deserialize(ByteBuffer clientBytes) {
        //clientBytes ???? // 1
        var id = clientBytes.getLong();
        var longValue = clientBytes.getLong();
        var length = clientBytes.getInt();
        var dataAsBytes = new byte[length];
        clientBytes.get(dataAsBytes);

        var booleans = clientBytes.getLong();
        var valueBool1 = getBit(booleans, 0);
        var valueBool2 = getBit(booleans, 1);

        var clientData = new ClientData(longValue, new String(dataAsBytes), valueBool1, valueBool2);
        return new Client(id, clientData);
    }

    private long setBit(long data, int bitIdx, boolean value) { // 2
        return 0;
    }

    private boolean getBit(long data, int bitIdx) { // 3
        return true;
    }
}
