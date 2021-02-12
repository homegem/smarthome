package com.poc.home.smart.temperaturestreamprocessing.streaming;

import com.poc.home.smart.models.Temperature;
import com.poc.home.smart.models.TemperatureKey;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StreamEnricher {
    @Value("#{kafkaConfig.getStreamInputTopicName()}")
    private String streamInputTopicName;
    @Value("#{kafkaConfig.getStreamOutputTopicName()}")
    private String streamOutputTopicName;
    @Value("#{kafkaConfig.getDataSourceName()}")
    private String dataSourceName;


    @Bean
    public KStream<TemperatureKey, Temperature> kStream(StreamsBuilder kStreamBuilder) {

        KStream<TemperatureKey, Temperature> convertedStream = kStreamBuilder
                .stream(streamInputTopicName, Consumed.with(Serdes.String(), Serdes.String()))
                .filter((key, value) -> this.checkValidity(value))
                .mapValues(this::valueTransformation)
                .mapValues(this::convertValueToAvro)
                .selectKey((key, value) -> this.convertKeyToAvro(value));

        convertedStream.to(streamOutputTopicName);

        return convertedStream;
    }

    protected boolean checkValidity(String value) {

        // check line emptiness
        if (value.trim().isEmpty()) {
            return false;
        }

        return true;
    }

    protected String valueTransformation(String value){

        return value
                .trim()
                .toLowerCase();
    }

    protected TemperatureKey convertKeyToAvro(Temperature product) {

        return TemperatureKey
                .newBuilder()
                .setSource("hello") // TODO
                .build();
    }

    protected Temperature convertValueToAvro(String value) {

        // get directly, because checked data validity in previous steps.
        return Temperature.newBuilder()
                .setSource("hello") // TODO
                .setTemperatureCelsius(0) // TODO
                .setTemperatureFahrenheit(0) // TODO
                .build();
    }
}
