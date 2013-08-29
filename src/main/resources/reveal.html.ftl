<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">

    <title>${config.title!'RevealOff'}</title>

    <#if config.description??><meta name="description" content="${config.description}"></#if>
    <#if config.author??><meta name="author" content="${config.author}"></#if>

    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" href="css/reveal.css">
    <link rel="stylesheet" href="css/theme/${config.theme}.css" id="theme">

    <!-- For syntax highlighting -->
    <link rel="stylesheet" href="lib/css/zenburn.css">

    <!-- If the query includes 'print-pdf', use the PDF print sheet -->
    <!-- TODO: Make pdf printing less manual, possibly with http://stackoverflow.com/a/11060206/69002 -->
    <script>
        document.write( '<link rel="stylesheet" href="css/print/' + ( window.location.search.match( /print-pdf/gi ) ? 'pdf' : 'paper' ) + '.css" type="text/css" media="print">' );
    </script>

    <!--[if lt IE 9]>
    <script src="lib/js/html5shiv.js"></script>
    <![endif]-->
</head>

<body>

<div class="reveal">

    <div class="slides">
    <#list slides as slide>
        <section>
        ${slide}
        </section>
    </#list>
    </div>

</div>

<script src="lib/js/head.min.js"></script>
<script src="js/reveal.min.js"></script>

<script>
  var option, i;

  var settings = {
      controls: true,
      progress: true,
      history: true,
      center: true,
      transition: 'default',
      plugins: ['zoom-js/zoom.js', 'notes/notes.js']
  };

  var config = ${config.json};

  for (option in config) {
      settings[option] = config[option];
  }

  var hasClassList = function () { return !!document.body.classList;};

  settings.dependencies = [
    { src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
    { src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } }
  ];

  for (i in settings.plugins) {
    settings.dependencies.push({ src: 'plugin/' + settings.plugins[i], async: true, callback: hasClassList });
  }
  Reveal.initialize(settings);
</script>

</body>
</html>
