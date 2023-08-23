package taller;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOInstances {

    public static Instances readCsv(String path) throws Exception {
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(new FileInputStream(path));

        Instances data = csvLoader.getDataSet();
        data.setClassIndex(0);
        return data;
    }

    public static void writeData(Instances data, String out) throws Exception  {
        CSVSaver csvSaver = new CSVSaver();
        csvSaver.setInstances(data);
        csvSaver.setDestination(new BufferedOutputStream(new FileOutputStream(out)));
        csvSaver.writeBatch();
    }
}
