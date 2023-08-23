package taller;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.BestFirst;
import weka.attributeSelection.CfsSubsetEval;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.util.Arrays;

public class CFSSubset {

    public static Instances bestSubset(Instances inst) throws Exception {

        AttributeSelection attributeSelection = new AttributeSelection();
        attributeSelection.setEvaluator(new CfsSubsetEval());
        attributeSelection.setSearch(new BestFirst());

        attributeSelection.SelectAttributes(inst);
        int[] posA = attributeSelection.selectedAttributes();

        Arrays.sort(posA);
        Remove rem = new Remove();
        rem.setAttributeIndicesArray(posA);
        rem.setInvertSelection(true);
        rem.setInputFormat(inst);
        Instances instRes =Filter.useFilter(inst, rem);
        return instRes;
    }
}
