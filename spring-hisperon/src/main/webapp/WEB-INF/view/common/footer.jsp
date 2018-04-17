<script src="${urlHome}/resources/js/jquery3.3.1.js"></script>
<c:forTokens items="${specificsJS}" delims="," var="varJs">
    <script src="${urlHome}/resources/js/${varJs}"></script>
</c:forTokens>