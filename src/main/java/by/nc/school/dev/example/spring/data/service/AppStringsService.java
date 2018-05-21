package by.nc.school.dev.example.spring.data.service;

public interface AppStringsService {

    interface WEB {
        String KEY = "web";
        interface LOGIN {
            String KEY = WEB.KEY + ".login";
            interface TITLE {
                String KEY = LOGIN.KEY + ".title";
            }
            interface USER {
                String KEY = LOGIN.KEY + ".user";
            }
            interface PASSWORD {
                String KEY = LOGIN.KEY + ".password";
            }
            interface SUBMIT {
                String KEY = LOGIN.KEY + ".submit";
            }
        }
        interface LOGOUT {
            String KEY = WEB.KEY + ".logout";
            interface SUBMIT {
                String KEY = LOGOUT.KEY + ".submit";
            }
        }
        interface GROUP {
            String KEY = WEB.KEY + ".group";
            interface TITLE {
                String KEY = GROUP.KEY + ".title";
            }
            interface TABLE {
                String KEY = GROUP.KEY + ".table";
                interface STUDENT {
                    String KEY = TABLE.KEY + ".fullname";
                }
            }
        }
        interface ADD_SUBJECT {
            String KEY = WEB.KEY + ".addsubject";
            interface TITLE {
                String KEY = ADD_SUBJECT.KEY + ".title";
            }
            interface SUBJECT {
                String KEY = ADD_SUBJECT.KEY + ".subject";
                interface NAME {
                    String KEY = SUBJECT.KEY + ".name";
                }
                interface SUBMIT {
                    String KEY = ADD_SUBJECT.KEY + ".submit";
                }
            }
            interface FINISH {
                String KEY = ADD_SUBJECT.KEY + ".finish";
            }
        }
        interface SUBJECT {
            String KEY = WEB.KEY + ".subject";
            interface TITLE {
                String KEY = SUBJECT.KEY + ".title";
            }
            interface LIST {
                String KEY = SUBJECT.KEY + ".list";
            }
        }
        interface ADD_WORKPLAN {
            String KEY = WEB.KEY + ".addworkplan";
            interface TITLE {
                String KEY = ADD_WORKPLAN.KEY + ".title";
            }
            interface SELECT_GROUP {
                String KEY = ADD_WORKPLAN.KEY + ".selectgroup";

                interface SELECT {
                    String KEY = SELECT_GROUP.KEY + ".select";
                }
            }
            interface ITEM {
                String KEY = ADD_WORKPLAN.KEY + ".item";
                interface SUBJECT {
                    String KEY = ITEM.KEY + ".subject";
                }
                interface TUTOR {
                    String KEY = ITEM.KEY + ".tutor";
                }
                interface ADDITEM {
                    String KEY = ITEM.KEY + ".add";
                }
            }
        }
        interface ADD_USER {
            String KEY = WEB.KEY + ".adduser";
            interface TITLE {
                String KEY = ADD_USER.KEY + ".title";
            }
            interface PERSON {
                String KEY = ADD_USER.KEY + ".person";
                interface FULLNAME {
                    String KEY = PERSON.KEY + ".fullname";
                }
                interface ROLE {
                    String KEY = PERSON.KEY + ".role";
                    interface STUDENT {
                        String KEY = ROLE.KEY + ".student";
                    }
                    interface TUTOR {
                        String KEY = ROLE.KEY + ".tutor";
                    }
                    interface CURATOR {
                        String KEY = ROLE.KEY + ".curator";
                    }
                    interface DEAN {
                        String KEY = ROLE.KEY + ".dean";
                    }
                    interface ADMIN {
                        String KEY = ROLE.KEY + ".admin";
                    }
                }
                interface GROUP {
                    String KEY = PERSON.KEY + ".group";
                }
            }
            interface SUBMIT {
                String KEY = ADD_USER.KEY + ".submit";
            }
        }
        interface ADD_GROUP {
            String KEY = WEB.KEY + ".addgroup";
            interface TITLE {
                String KEY = ADD_GROUP.KEY + ".title";
            }
            interface INIT {
                String KEY = ADD_GROUP.KEY + ".init";
                interface TITLE {
                    String KEY = INIT.KEY + ".title";
                }
                interface GROUPNUMBER {
                    String KEY = INIT.KEY + ".groupnumber";
                }
                interface SUBMIT {
                    String KEY = INIT.KEY + ".submit";
                }
            }
            interface CURATOR {
                String KEY = ADD_GROUP.KEY + ".curator";
//                interface USERNAME {
//                    String KEY = TABLE.KEY + ".username";
//                }
//                interface PASSWORD {
//                    String KEY = TABLE.KEY + ".password";
//                }
//                interface FULLNAME {
//                    String KEY = CURATOR.KEY + ".fullname";
//                }
            }
            interface TABLE {
                String KEY = ADD_GROUP.KEY + ".table";
                interface USERNAME {
                    String KEY = TABLE.KEY + ".username";
                }
                interface PASSWORD {
                    String KEY = TABLE.KEY + ".password";
                }
                interface FULLNAME {
                    String KEY = TABLE.KEY + ".fullname";
                }
            }
            interface ADD_STUDENT {
                String KEY = ADD_GROUP.KEY + ".addstudent";
                interface TITLE {
                    String KEY = ADD_STUDENT.KEY + ".title";
                }
//                interface USERNAME {
//                    String KEY = ADD_STUDENT.KEY + ".username";
//                }
//                interface PASSWORD {
//                    String KEY = ADD_STUDENT.KEY + ".password";
//                }
//                interface FULLNAME {
//                    String KEY = ADD_STUDENT.KEY + ".fullname";
//                }
                interface SUBMIT {
                    String KEY = ADD_STUDENT.KEY + ".submit";
                }
            }
            interface CREATE {
                String KEY = ADD_GROUP.KEY + ".create";
            }
        }
        interface HOME {
            String KEY = WEB.KEY + ".home";
            interface TITLE {
                String KEY = HOME.KEY + ".title";
            }
            interface TABLE {
                String KEY = HOME.KEY + ".table";
                interface USER {
                    String KEY = TABLE.KEY + ".user";
                }
                interface PASSWORD {
                    String KEY = TABLE.KEY + ".password";
                }
                interface FULLNAME {
                    String KEY = TABLE.KEY + ".fullname";
                }
                interface ROLE {
                    String KEY = TABLE.KEY + ".role";
                }
            }
        }
        interface JOURNAL {
            String KEY = WEB.KEY + ".journal";
            interface TITLE {
                String KEY = JOURNAL.KEY + ".title";
            }
            interface TABLE {
                String KEY = JOURNAL.KEY + ".table";
                interface TITLE {
                    String KEY = TABLE.KEY + ".title";
                }
                interface STUDENTS {
                    String KEY = TABLE.KEY + ".students";
                }
                interface AVERAGE_MARK {
                    String KEY = TABLE.KEY + ".averagemark";
                }
            }
            interface SELECT_SUBJECT {
                String KEY = JOURNAL.KEY + ".selectsubject";
                interface BUTTON {
                    String KEY = SELECT_SUBJECT.KEY + ".button";
                }
            }
            interface SELECT_GROUP {
                String KEY = JOURNAL.KEY + ".selectgroup";
                interface BUTTON {
                    String KEY = SELECT_GROUP.KEY + ".button";
                }
            }
            interface PUT_MARK {
                String KEY = JOURNAL.KEY + ".putmark";

                interface SELECT_LESSON {
                    String KEY = PUT_MARK.KEY + ".selectlesson";
                }

                interface SELECT_STUDENT {
                    String KEY = PUT_MARK.KEY + ".selectstudent";
                }

                interface SELECT_MARK {
                    String KEY = PUT_MARK.KEY + ".selectmark";
                }

                interface BUTTON {
                    String KEY = PUT_MARK.KEY + ".button";
                }
            }
            interface ADD_LESSON {
                String KEY = JOURNAL.KEY + ".addlesson";

                interface LESSON {
                    String KEY = ADD_LESSON.KEY + ".lesson";
                }

                interface BUTTON {
                    String KEY = ADD_LESSON.KEY + ".button";
                }
            }
        }
        interface ANALYSIS {
            String KEY = WEB.KEY + ".analysis";
            interface TITLE {
                String KEY = ANALYSIS.KEY + ".title";
            }
            interface STUDENTS_WITH_BAD_AVERAGE_MARK {
                String KEY = ANALYSIS.KEY + ".badstudents";
            }
            interface STUDENTS_WITH_EXCELLENT_MARKS {
                String KEY = ANALYSIS.KEY + ".goodstudents";
            }
        }
        interface ERROR {
            String KEY = WEB.KEY + ".error";
            interface TITLE {
                String KEY = ANALYSIS.KEY + ".title";
            }
            interface MESSAGE {
                String KEY = ANALYSIS.KEY + ".message";
            }
        }
    }

    String getString(String key);

    String getString(String key, Object... substitution);

}
