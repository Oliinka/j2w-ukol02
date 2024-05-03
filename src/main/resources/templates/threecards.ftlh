[#ftl]
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

<div class="blockquote-container">

<blockquote >
    <strong> PAST / SITUATION: </strong>

    <div class="content">
        <div class="text-left-3">${tarotMeaning1}</div>
        <div class="image">
            <img src="images/cards/Tarot_${card1}.jpg" alt="tarot card">

    </div>
    </div>

</blockquote>
<blockquote>
    <strong> PRESENT/ACTION: </strong>

    <div class="content">
        <div class="text-left-3">${tarotMeaning2}</div>
        <div class="image">
            <img src="images/cards/Tarot_${card2}.jpg" alt="tarot card">

    </div>
    </div>
</blockquote>
<blockquote>
    <strong> FUTURE/OUTCOME: </strong>
    <div class="content">
        <div class="text-left-3">${tarotMeaning3}</div>
        <div class="image">
            <img src="images/cards/Tarot_${card3}.jpg" alt="tarot card">
        </div>
    </div>
</blockquote>
</div>

</body>
</html>
