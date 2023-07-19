<!DOCTYPE html>
<html lang="en">
<head>
  <title>Error Page</title>
  <link href="/static/css/style.css" rel="stylesheet">
</head>
<body>
<header class="top-header"></header>

<!-- Dust particles -->
<div>
  <div class="starsec"></div>
  <div class="starthird"></div>
  <div class="starfourth"></div>
  <div class="starfifth"></div>
</div>
<!-- End dust particles -->

<div class="lamp__wrap">
  <div class="lamp">
    <div class="cable"></div>
    <div class="cover"></div>
    <div class="in-cover">
      <div class="bulb"></div>
    </div>
    <div class="light"></div>
  </div>
</div>
<!-- END Lamp -->

<section class="error">
  <!-- Content -->
  <div class="error__content">
    <div class="error__message message">
      <h1 class="message__title">Error 404 Page Not Found</h1>
      <p class="message__text">${message}</p>
    </div>
    <div class="error__nav e-nav">
      <a href="/code/new" class="e-nav__link"></a>
    </div>
  </div>
  <!-- END Content -->
</section>
</body>
</html>
