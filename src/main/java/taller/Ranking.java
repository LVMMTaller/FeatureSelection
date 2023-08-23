package taller;

import weka.attributeSelection.*;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.util.Arrays;

public class Ranking {
    public static Instances bestSubset(Instances inst, int n) throws Exception {

        AttributeSelection attributeSelection = new AttributeSelection();
        attributeSelection.setEvaluator(new ReliefFAttributeEval());

        Ranker ranker = new Ranker();
        ranker.setNumToSelect(n);
        attributeSelection.setSearch(ranker);

        attributeSelection.SelectAttributes(inst);
        int[] posA = attributeSelection.selectedAttributes();

        Arrays.sort(posA);
        Remove rem = new Remove();
        rem.setAttributeIndicesArray(posA);
        rem.setInvertSelection(true);
        rem.setInputFormat(inst);
        Instances instRes = Filter.useFilter(inst, rem);
        return instRes;
    }
}
