 function setCookie(cookie, value, expire) {
    const date = new Date();
    date.setTime(date.getTime() + (expire*24*60*60*1000));
    let expires = "expires=" + date.toUTCString();
    document.cookie = cookie + "=" + value + ";" + expires + ";path=/";
}

function getCookie(cookie) {
    let name = cookie + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let cookieArray = decodedCookie.split(";");
    
    for (let i = 0; i < cookieArray.length; i++) {
        let c = cookieArray[i];
        
        while (c.charAt(0) === " ") {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}