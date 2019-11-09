import os
import re

import requests


# 解析各章节url
def get_toc_url_list(url):
    response = requests.get(url)
    response.encoding = 'gb2312'  # 如果中文乱码需要制定编码方式，可通过浏览器查看网页源码看下编码方式
    toc_block = re.findall('正文(.*?)</tbody>', response.text, re.S)[0]
    toc_url_list = re.findall('<a href="(.*?)">', toc_block, re.S)
    toc_url_list = [response.url + x for x in toc_url_list]
    return toc_url_list


# 从章节url中获取文章名和文章内容
def get_chapter_name_and_text(url):
    response = requests.get(url)
    response.encoding = 'gb2312'
    chapter_name = re.search('size="4">(.*?)<', response.text, re.S).group(1).strip()
    text_block = re.search('<p>(.*?)</p>', response.text, re.S).group(1).strip().replace('<br />', '')
    return chapter_name, text_block


# 保存文章到文件中
def save_chapter_file(name, text, base_path):
    os.makedirs(base_path, exist_ok=True)  # 文件不存在时创建
    file_path = os.path.join(base_path, name)
    with open(file_path, 'w') as file:
        file.write(text)


# 爬虫电子书并保存各章节到文件
url = 'https://www.kanunu8.com/book3/6879/'
base_path = '/tmp/book/'
url_list = get_toc_url_list(url)
for v in url_list:
    name, text = get_chapter_name_and_text(v)
    print(v, '保存内容到文件 章节', name)
    save_chapter_file(name, text, base_path)
