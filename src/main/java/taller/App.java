package taller;

import weka.core.Instances;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        String path = "ACE_coop_ejec1.csv_2100.csv";
        Instances dataOriginal = IOInstances.readCsv(path);

        Instances cfsSel = CFSSubset.bestSubset(dataOriginal);

        Instances ran = Ranking.bestSubset(dataOriginal,cfsSel.numAttributes()-1);

        IOInstances.writeData(cfsSel,path+"_cfs.csv");
        IOInstances.writeData(ran,path+"_rank.csv");
    }
}
