package Manager;

public class AuthenticationException extends Exception{
    public AuthenticationException(String message) {
            super(message);
        }
    }

    class Authenticator {
        public static void authenticate(String username, char[] password) throws AuthenticationException {
            String passwordStr = new String(password);

            if ("admin".equals(username) && "admin".equals(passwordStr)) {
                System.out.println("Authentication successful!");
            } else {
                throw new AuthenticationException("Incorrect username or password");
            }
        }
    }