var red = {
    color1: "#F8E0E0",
    color2: "#F6CECE",
    color3: "#F5A9A9",
    color4: "#F78181",
    color5: "#FA5858",
    color6: "#FE2E2E",
    color7: "#FF0000"
}

var blue = {
    color1: "#EFFBFB",
    color2: "#E0F8F7",
    color3: "#CEF6F5",
    color4: "#A9F5F2",
    color5: "#81F7F3",
    color6: "#58FAF4",
    color7: "#2EFEF7"
}

var purple = {
    color1: "#F5EFFB",
    color2: "#ECE0F8",
    color3: "#E3CEF6",
    color4: "#D0A9F5",
    color5: "#BE81F7",
    color6: "#AC58FA",
    color7: "#9A2EFE"
}

var pink = {
    color1: "#FBEFFB",
    color2: "#F8E0F7",
    color3: "#F6CEF5",
    color4: "#F5A9F2",
    color5: "#F781F3",
    color6: "#FA58F4",
    color7: "#FE2EF7"
}


var ezkitstr = `

%c:::::::::: :::::::::  :::    ::: ::::::::::: ::::::::::: 
%c:+:             :+:   :+:   :+:      :+:         :+:     
%c+:+            +:+    +:+  +:+       +:+         +:+     
%c+#++:++#      +#+     +#++:++        +#+         +#+     
%c+#+          +#+      +#+  +#+       +#+         +#+     
%c#+#         #+#       #+#   #+#      #+#         #+#     
%c########## #########  ###    ### ###########     ###   

`

var name = `
%c찬호 %c동윤 %c범기 %c다혜
`


console.log(ezkitstr, `color:${red.color1}`,
    `color:${red.color2}`,
    `color:${red.color3}`,
    `color:${red.color4}`,
    `color:${red.color5}`,
    `color:${red.color6}`,
    `color:${red.color7}`
)
console.log(name, `color:${purple.color5}`,
    `color:${pink.color5}`,
    `color:${red.color5}`,
    `color:${blue.color5}`
)