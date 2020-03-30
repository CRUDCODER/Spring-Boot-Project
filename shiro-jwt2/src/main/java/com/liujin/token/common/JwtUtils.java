package com.liujin.token.common;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author liujin
 * @date created in 2020/2/19 15:36
 */
@Slf4j
public class JwtUtils {
    private Logger log= LoggerFactory.getLogger(JwtUtils.class);
    /**
     *设置token过期时间 单位秒
     */
    private Long EXPIRATION_TIME=3000L;
    /**
     *    加密盐
     */
    private final String SECRET="A0B1C2D3E4F5G6H7I8J9KALBMCNDOEPFQ0R1S2T3U4V5W6X7Y8Z9";
    /**
     * token头信息
     */
    private final String TOKEN_PREFIX="Bearer";
    /**
     * header中认证字段
     */
    private final String HEADER_NAME="authorization";
    /**
     * 生成token信息并返回
     * @param claims
     * @return
     */
    public Map<String,Object> generateToken(Map<String, Object> claims){
        if (Objects.isNull(claims)){
            claims=new HashMap<>(16);
        }
        Map<String,Object> map=new HashMap<>(16);
        Date date = new Date(System.currentTimeMillis() + EXPIRATION_TIME*1000);
        log.info("过期时间：{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        String jwt= Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .compact();
        log.debug("生成的token:{}",jwt);
        map.put("token",TOKEN_PREFIX+" "+jwt);
        map.put("token-type", TOKEN_PREFIX);
        map.put("expire-time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) );
        return map;
    }
    /**
     * 检验并解析token
     * IllegalArgumentException:JWT字符串参数不能为空或null。
     * SignatureException:字符串伪造 并不是服务端颁发的token
     * MalformedJwtException:字符串缺失
     * ExpiredJwtException：token已过期
     * UnsupportedJwtException:未知
     */
    public Object validateTokenAndGetClaims(String token){
        Map<String,Object> body = null;
        try {
            body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        }catch (UnsupportedJwtException e) {
            e.printStackTrace();
        }
        return body.get("username");
    }
    public String getHEADER_NAME() {
        return HEADER_NAME;
    }

    /**
     * 根据token获取用户姓名
     * @return
     */
    public  String getUsernameByToken(String token){
        String claims=token.replace(TOKEN_PREFIX, "");

        Jws<Claims> claimsJws=Jwts.parser().setSigningKey(SECRET).parseClaimsJws(claims);
        log.info("claimsJws:{}",claimsJws);
        Map<String,Object>map= claimsJws.getBody();
        return (String) map.get("username");
    }

}
