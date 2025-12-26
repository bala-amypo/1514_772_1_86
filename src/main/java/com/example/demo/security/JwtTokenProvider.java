public String generateToken(String username, String role) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

    return Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key(), SignatureAlgorithm.HS256)
            .compact();
}
