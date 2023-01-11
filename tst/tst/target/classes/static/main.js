$(document).ready(function(){
    $("button").click(function(){
        let zone = $(this).text();
        let $sights =$('#cards')
        console.log(zone);
        $.ajax({
            method: 'GET',
            url: '/SightAPI?zone=' + zone,
            success: function(sights){
                $sights.html("");
                $.each(sights, function(i,sight){
                    let ShowCard = $("<div></div>").attr("id","ShowCard");
                    let card = $("<div></div>").addClass("card");
                    let cardHeader = $("<div></div>").addClass("card-header").text(sight.sightName);
                    console.log(sight.sightName);
                    let cardBody = $("<div></div>").addClass("card-body");
                    let bodyContent = $("<p></p>");
                    bodyContent.append(`區域 : ${sight.zone}`,"</br>",`分類 : ${sight.category}`);
                    let address = $("<a></a>").addClass("btn")
                                              .attr("id","addressBtn")
                                              .attr("href",`https://www.google.com.tw/maps/place/${sight.address}`)
                                              .attr("target","blank")
                                              .text("地址");
                    let descriptionCard = $("<div></div>").addClass("cardFooter");
                    let descriptionHeader = $("<div></div>").addClass("cardFooter-header");
                    let img = $("<img>").attr("src",sight.photoURL);
                    let descriptionTitle = $("<a></a>").addClass("btn")
                                                       .attr("data-bs-toggle","collapse")
                                                       .attr("id","collapseBtn")
                                                       .attr("href",`#collapse${i}`)
                                                       .text("詳細資訊");
                    descriptionHeader.append(descriptionTitle);
                    let descriptionCollapse = $("<div></div>").addClass("collapse").attr("id",`collapse${i}`);
                    let descriptionBody = $("<div></div>").addClass("card-body").text(sight.description);

                    if(sight.photoURL != "") descriptionCollapse.append(img,descriptionBody);
                    else descriptionCollapse.append(descriptionBody);
                    descriptionCard.append(descriptionHeader,descriptionCollapse);

                    cardBody.append(address,bodyContent);
                    card.append(cardHeader,cardBody);
                    ShowCard.append(card,descriptionCard);
                    $sights.append(ShowCard);
                });
            }
        });
    });
});