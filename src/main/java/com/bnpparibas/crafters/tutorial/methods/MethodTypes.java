package com.bnpparibas.crafters.tutorial.methods;

import java.util.UUID;

public class MethodTypes {

    private final DataSink dataSinkService;
    private DataSource dataSourceService;
    private long internalCounter;
    private DataRef data;

    //@Autowired
    public MethodTypes(DataSink dataSink, DataSource dataSource) {
        dataSinkService = dataSink;
        dataSourceService = dataSource;
    }

    public void signalConsumer() {
        internalCounter++;
    }

    public void signalPublisher() {
        dataSinkService.increment();
    }

    public long signalProducer() {
        return internalCounter;
    }

    public void dataConsumer(DataRef data) {
        this.data = data;
    }

    public void dataPublisher(DataRef data) {
        dataSinkService.save(data);
    }

    public DataRef dataProducer() {
        return dataSourceService.fetchNewData();
    }

    public DataRef dataProducerFiltered(UUID id) {
        return dataSourceService.fetchDataBy(id);
    }
}
