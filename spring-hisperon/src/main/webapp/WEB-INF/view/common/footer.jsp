<script src="${urlHome}/resources/js/jquery.js?v=0.8"></script>
<c:forTokens items="${specificsJS}" delims="," var="varJs">
    <script src="${urlHome}/resources/js/${varJs}"></script>
</c:forTokens>