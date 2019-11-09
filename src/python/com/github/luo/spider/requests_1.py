import re

import requests


# 正则解析公众号文章的图片地址
def parse_img_urls(url):
    content = requests.get(url).text
    return re.findall('data-src="(https://mmbiz.*?)"', str(content))


url = 'https://mp.weixin.qq.com/s?__biz=MzIwNTI2ODY5OA==&mid=2649938635&idx=1&sn=fc22d218fb1529e8f4c1fcb659838d75&chksm=8f35097eb8428068258b95a652e46ed082499b3952ac11af2027400db758a1ac4b158412aeea&token=809264498&lang=zh_CN#rd'
for url in parse_img_urls(url):
    print(url)
