import jakarta.servlet.http.HttpServletRequest;

public String getUserIdFromRequest(HttpServletRequest request) {

    String header = request.getHeader("Authorization");

    if (header != null && header.startsWith("Bearer ")) {
        String token = header.substring(7);
        return getUsernameFromToken(token);
    }

    return null;
}
