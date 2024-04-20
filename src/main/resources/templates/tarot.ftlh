[#ftl ]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quote of the day</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://fonts.gstatic.com" rel="preconnect">
   <link href="/css/style.css" rel="stylesheet">
    <link href="/images/icon_olii.png" rel="icon" type="image/png">

</head>
<body style="background-image: url('/images/background_${randomBackground}.jpg');">

<blockquote>
    <strong> YOUR CARD NUMBER IS: ${randomCard}</strong>
    <pre>
        ${tarotMeaning}
    </pre>
</blockquote>

<blockquote>
    <img src="images/cards/RWS_Tarot_${randomCard}.jpg" width="500" alt="tarot card">
</blockquote>

</body>
</html>
