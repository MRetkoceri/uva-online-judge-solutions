package Other.regional2015SouthAfrica;

import java.util.*;

/**
 * Created by Muhamed on 9/17/2016.
 */
public class LongestSquareSubsequence {
    private static List<List<Integer>> listDoubleSequences(String in)
    {
        List<List<Integer>> result = new ArrayList<>();

        //map all characters to their indices in the inputstring
        HashMap<Character , List<Integer>> posMap = new HashMap<>();

        for(int i = 0 ; i < in.length() ; i++)
        {
            char c = in.charAt(i);

            if(posMap.get(c) == null)
                posMap.put(c , new ArrayList<>());

            posMap.get(c).add(i);
        }

        posMap.values().forEach(indices -> {
            //find all possible permutations with length 2
            for (int i = 0; i < indices.size(); i++)
                for (int j = i + 1; j < indices.size(); j++) {
                    List<Integer> seq = new ArrayList<>();
                    seq.add(indices.get(i));
                    seq.add(indices.get(j));

                    result.add(seq);
                }
        });

        return result;
    }

    private static List<Integer> merge(List<Integer> a , List<Integer> b)
    {
        if(a.contains(b.get(0)) || a.contains(b.get(1)))
            return null;

        List<Integer> result = new ArrayList<>(a);

        result.addAll(b);
        Collections.sort(result);

        //check whether the indices from b have been inserted correctly
        //split the sequence into two parts of same length, now the position of b.get(0)
        //in the first part must be equal to the position of b.get(1) in the second part
        if(result.indexOf(b.get(1)) - result.indexOf(b.get(0)) == result.size() / 2)
            return result;
        else
            return null;
    }

    public static int sqrSubseqCount(String in)
    {
        List<List<Integer>> len_2_seq = listDoubleSequences(in);
        List<List<Integer>> prev_round = new ArrayList<>(len_2_seq);
        final Set<List<Integer>> next_round = new HashSet<>();
        int max = -1;
        int count = len_2_seq.size();
        while(!prev_round.isEmpty())
        {
            next_round.clear();
            prev_round.forEach(l -> len_2_seq.forEach(l2 -> {
                List<Integer> merge = merge(l , l2);

                if(merge != null && !next_round.contains(merge))
                {
                    next_round.add(merge);
                }
            }));

            count += next_round.size();
            for(List<Integer>l:next_round){
                if(max < l.size())
                    max = l.size();
            }
            prev_round.clear();
            prev_round.addAll(next_round);
        }
        return max;
    }

    public static void main(String[]arg){
        System.out.println(sqrSubseqCount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaa"));
    }
}
