package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user1 = new User("name", false);
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            } else {
                throw new UserNotFoundException("A user with this name was not found");
            }
        }
        return user1;
    }

    public static boolean validate(User user) throws UserInvalidException {
        String el = user.getUsername();
        if (el.length() > 3 && user.isValid()) {
            return true;
        } else {
            throw new UserInvalidException("The user isn't valid");
        }
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");

            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException us) {
            us.printStackTrace();
        } catch (UserNotFoundException us1) {
            us1.printStackTrace();
        }
    }
}
