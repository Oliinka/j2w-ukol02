[#ftl ]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>One card answer</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://fonts.gstatic.com" rel="preconnect">
   <link href="/css/style.css" rel="stylesheet">
    <link href="/images/icon_olii.png" rel="icon" type="image/png">

</head>
<body style="background-image: url('/images/background_${randomBackground}.jpg');">

<header>
    <nav>
        <div class="topnav" id="myTopnav">
            <a href="index.html" class="button">HOME</a>
        </div>
    </nav>
</header>

<blockquote>
    <h2><strong> YOUR CARD NUMBER IS: ${randomCard}</strong></h2>
    <div class="content">
        <div class="text-left">${tarotMeaning}</div>
        <div class="image">
            <img src="images/cards/RWS_Tarot_${randomCard}.jpg" alt="tarot card">
        </div>
    </div>
</blockquote>

</body>
</html>