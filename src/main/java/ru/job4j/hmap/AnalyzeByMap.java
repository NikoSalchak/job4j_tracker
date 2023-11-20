package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        double subjects = 0D;
        for (int index = 0; index < pupils.size(); index++) {
            for (int j = 0; j < pupils.get(index).subjects().size(); j++) {
                score += pupils.get(index).subjects().get(j).score();
                subjects += index;
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        int score = 0;
        List<Label> label = new ArrayList<>();
        for (int index = 0; index < pupils.size(); index++) {
            for (int j = 0; j < pupils.get(index).subjects().size(); j++) {
              score = score + pupils.get(index).subjects().get(j).score();
            }
            label.add(new Label(pupils.get(index).name(),  (double) score / pupils.get(index).subjects().size()));
            score = 0;
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int index = 0; index < pupils.size(); index++) {
            for (int j = 0; j < pupils.get(index).subjects().size(); j++) {
                map.put(pupils.get(index).subjects().get(j).name(),
                        map.getOrDefault(pupils.get(index).subjects().get(j).name(), 0)
                                + pupils.get(index).subjects().get(j).score());
                System.out.println(map);
            }
        }
        List<Label> label = new ArrayList<>();
        for (String key : map.keySet()) {
            label.add(new Label(key, (double) map.get(key) / pupils.size()));
        }
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        Label pupil = null;
        int score = 0;
        for (int index = 0; index < pupils.size(); index++) {
            for (int j = 0; j < pupils.get(index).subjects().size(); j++) {
                score = score + pupils.get(index).subjects().get(j).score();
            }
            label.add(new Label(pupils.get(index).name(), score));
            score = 0;
        }
        label.sort(Comparator.naturalOrder());
        for (Label value : label) {
            pupil = value;
        }
        return pupil;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Label subject = null;
        for (int index = 0; index < pupils.size(); index++) {
            for (int j = 0; j < pupils.get(index).subjects().size(); j++) {
                map.put(pupils.get(index).subjects().get(j).name(),
                        map.getOrDefault(pupils.get(index).subjects().get(j).name(), 0)
                                + pupils.get(index).subjects().get(j).score());
            }
        }
        List<Label> label = new ArrayList<>();
        for (String key : map.keySet()) {
            label.add(new Label(key, (double) map.get(key)));
            label.sort(Comparator.naturalOrder());
        }
        for (Label value : label) {
            subject = value;
        }
        return subject;
    }
}
