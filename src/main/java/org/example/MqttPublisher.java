package org.example;

import org.eclipse.paho.client.mqttv3.*;


public class MqttPublisher {

    public void publishDeviceInfo() throws MqttException {

        String serverUri = "tcp://test.mosquitto.org:1883";
        String clientId = MqttClient.generateClientId();

        MqttClient client = new MqttClient(serverUri, clientId);

        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);

            client.connect(options);

            String topic = "device/info";
            MqttMessage message = new MqttMessage("Hello! Giriraj :)!".getBytes());
            message.setQos(1);

            client.publish(topic, message);


            client.disconnect();

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}