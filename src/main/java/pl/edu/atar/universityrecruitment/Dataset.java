package pl.edu.atar.universityrecruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dataset {

    public Dataset() {
    }

    public List<UniversityCandidate> getUniversityCandidates() {

        List<UniversityCandidate> uc = new ArrayList<UniversityCandidate>();

        uc.add(new UniversityCandidate(1L, "Anna", "Kowalewska", 120.0, null, "Informatyka", Boolean.TRUE, "Female"));
        uc.add(new UniversityCandidate(2L, "Jacek", "Nowak", 110.0, null, "Informatyka", Boolean.FALSE, "Male"));
        uc.add(new UniversityCandidate(3L, "Ewa", "Wiśniowa", 35.0, null, "Elektrotechnika", Boolean.FALSE, "Female"));
        uc.add(new UniversityCandidate(4L, "Karol", "Gruszka", 135.0, null, "Automatyka i robotyka", Boolean.TRUE, "Male"));
        uc.add(new UniversityCandidate(5L, "Kinga", "Poziomka", 45.0, null, "Elektrotechnika", Boolean.TRUE, "Female"));

        return uc;
    }

    public List<UniversityCandidate> getUniversityCandidatesWithSubjects() {

        List<UniversityCandidate> uc = new ArrayList<UniversityCandidate>();
        ArrayList<ExamSubjectResult> esr = new Dataset().getExamSubjectResult();

        uc.add(new UniversityCandidate(1L, "Anna", "Kowalewska", new ArrayList<>(esr.subList(0, 5)), null, "Informatyka", Boolean.TRUE, "Female"));
        uc.add(new UniversityCandidate(2L, "Jacek", "Nowak", new ArrayList<>(esr.subList(5, 8)), null, "Informatyka", Boolean.FALSE, "Male"));
        uc.add(new UniversityCandidate(3L, "Ewa", "Wiśniowa", new ArrayList<>(esr.subList(8, 12)), null, "Elektrotechnika", Boolean.FALSE, "Female"));
        uc.add(new UniversityCandidate(4L, "Karol", "Gruszka", new ArrayList<>(esr.subList(12, 16)), null, "Automatyka i robotyka", Boolean.TRUE, "Male"));
        uc.add(new UniversityCandidate(5L, "Kinga", "Poziomka", new ArrayList<>(esr.subList(16, 20)), null, "Elektrotechnika", Boolean.TRUE, "Female"));
        uc.add(new UniversityCandidate(6L, "Maja", "Czereśnia", new ArrayList<>(esr.subList(20, 25)), null, "Pielęgniarstwo", Boolean.TRUE, "Female"));
        uc.add(new UniversityCandidate(7L, "Karol", "Dąb", new ArrayList<>(esr.subList(25, 28)), null, "Psychologia", Boolean.FALSE, "Male"));

        return uc;
    }

    public ArrayList<ExamSubjectResult> getExamSubjectResult() {

        return new ArrayList<ExamSubjectResult>(Arrays.asList(
                new ExamSubjectResult("język polski", "podstawowy", 35D),
                new ExamSubjectResult("matematyka", "rozszerzony", 80D),
                new ExamSubjectResult("język angielski", "podstawowy", 55D),
                new ExamSubjectResult("informatyka", "podstawowy", 95D),
                new ExamSubjectResult("biologia", "podstawowy", 77D),

                new ExamSubjectResult("język polski", "podstawowy", 44D),
                new ExamSubjectResult("matematyka", "podstawowy", 40D),
                new ExamSubjectResult("język angielski", "podstawowy", 33D),

                new ExamSubjectResult("język polski", "podstawowy", 87D),
                new ExamSubjectResult("matematyka", "rozszerzony", 56D),
                new ExamSubjectResult("język angielski", "podstawowy", 44D),
                new ExamSubjectResult("fizyka", "rozszerzony", 31D),

                new ExamSubjectResult("język polski", "podstawowy", 59D),
                new ExamSubjectResult("matematyka", "podstawowy", 72D),
                new ExamSubjectResult("język angielski", "podstawowy", 33D),
                new ExamSubjectResult("informatyka", "rozszerzony", 88D),

                new ExamSubjectResult("język polski", "podstawowy", 99D),
                new ExamSubjectResult("matematyka", "rozszerzony", 44D),
                new ExamSubjectResult("język angielski", "podstawowy", 77D),
                new ExamSubjectResult("chemia", "rozszerzony", 100D),

                new ExamSubjectResult("język polski", "podstawowy", 80D),
                new ExamSubjectResult("matematyka", "rozszerzony", 46D),
                new ExamSubjectResult("język angielski", "podstawowy", 45D),
                new ExamSubjectResult("biologia", "rozszerzony", 80D),
                new ExamSubjectResult("chemia", "rozszerzony", 68D),

                new ExamSubjectResult("język polski", "rozszerzony", 90D),
                new ExamSubjectResult("matematyka", "podstawowy", 80D),
                new ExamSubjectResult("język angielski", "podstawowy", 90D)));
    }
}