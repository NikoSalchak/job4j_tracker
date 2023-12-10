package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        double subjects = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        int score = 0;
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            label.add(new Label(pupil.name(), (double) score / pupil.subjects().size()));
            score = 0;
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
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
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            label.add(new Label(pupil.name(), score));
            score = 0;
        }
        Label max = label.get(0);
        for (Label student : label) {
            if (student.score() > max.score()) {
                max = student;
            }
        }
        return max;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> label = new ArrayList<>();
        for (String key : map.keySet()) {
            label.add(new Label(key, (double) map.get(key)));
        }
        Label max = label.get(0);
        for (Label subject : label) {
            if (subject.score() > max.score()) {
                max = subject;

            }
        }
        return max;
    }
}
