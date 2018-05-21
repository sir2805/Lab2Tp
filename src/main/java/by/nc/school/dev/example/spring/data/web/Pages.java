package by.nc.school.dev.example.spring.data.web;

public interface Pages {

    interface VIEWS {
        String PATH_ABSOLUTE = "/";
        interface LOGIN {
            String PATH = "/login";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "login";
        }
        interface HOME {
            String PATH = "/home";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "home";
        }
        interface BROWSE_MARKS {
            String PATH = "/browse-marks";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "browse-marks";
        }
        interface PUT_MARKS {
            String PATH = "/put-marks";
            String PATH_ABSOLUTE = PATH;
            String VIEW = "put-marks";
        }
    }

    interface SUBJECT {
        String PATH_ABSOLUTE = "/subject";
        interface ADD_SUBJECT {
            interface ADD {
                String PATH = "/add-subject";
                String PATH_ABSOLUTE = SUBJECT.PATH_ABSOLUTE + PATH;
            }
            interface FINISH {
                String PATH = "/finish";
                String PATH_ABSOLUTE = SUBJECT.PATH_ABSOLUTE + PATH;
            }
        }
    }

    interface JOURNAL {
        String PATH_ABSOLUTE = "/journal";
        interface SELECT_GROUP {
            String PATH = "/select-group";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
        interface SELECT_SUBJECT {
            String PATH = "/select-subject";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
        interface PUT_MARK {
            String PATH = "/put-mark";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
        interface ADD_LESSON {
            String PATH = "/add-lesson";
            String PATH_ABSOLUTE = JOURNAL.PATH_ABSOLUTE + PATH;
        }
    }

    interface USER {
        String PATH_ABSOLUTE = "/user";
        interface LOGIN {
            String PATH = "/login";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
        interface LOGOUT {
            String PATH = "/logout";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
        interface NEW_USER {
            String PATH = "/new-user";
            String PATH_ABSOLUTE = USER.PATH_ABSOLUTE + PATH;
        }
    }


}
