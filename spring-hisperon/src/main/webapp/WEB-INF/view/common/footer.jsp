<script src="${resourcesUrl}js/jquery.js"></script>
<c:forTokens items="${specificsJS}" delims="," var="varJs">
    <script src="${resourcesUrl}js/${varJs}"></script>
</c:forTokens>