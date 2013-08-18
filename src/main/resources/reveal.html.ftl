<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">

    <title>${title!'A RevealOff Presentation'}</title>

    <#if description??><meta name="description" content="${description}"></#if>
    <#if author??><meta name="author" content="${author}"></#if>

    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" href="css/reveal.css">
    <link rel="stylesheet" href="css/theme/default.css" id="theme">

    <!-- For syntax highlighting -->
    <link rel="stylesheet" href="lib/css/zenburn.css">

    <!-- If the query includes 'print-pdf', use the PDF print sheet -->
    <!-- TODO: Make pdf printing less manual -->
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
    Reveal.initialize({
        // TODO: configure these & plugins from data model
        controls: true,
        progress: true,
        history: true,
        center: true,

        transition: 'default',

        // Optional libraries used to extend on reveal.js
        dependencies: [
            { src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
            { src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
            { src: 'plugin/zoom-js/zoom.js', async: true, condition: function() { return !!document.body.classList; } },
            { src: 'plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } }
//            { src: 'plugin/remotes/remotes.js', async: true, condition: function() { return !!document.body.classList; } }
        ]
    });

</script>

</body>
</html>