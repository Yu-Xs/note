#-*- coding: utf-8
"""
requirements:
    PyExecJS
    requests
"""
import sys, os, re, requests, execjs

def get_page_list(content):
    print ("  Fetching page list ...")
    page_list = []
    pat_select = r'<select[^>]+id="pagelist"[^>]+>(.*?)<\/select>'  
    pat_option = r'<option[^>]+value=\'(.*?)\'>'

    match = re.search(pat_select, content, flags=re.I|re.M|re.X)
    if match:
        for item in re.finditer(pat_option, match.group(0), flags=re.I|re.M|re.X):
            page_list.append(item.group(1))

    print ("  %d pages in total. % len(page_list)")
    return page_list

def get_page_title(content):
    pat_title = r'<h1>(.*?)<\/h1>'
    match = re.search(pat_title, content, flags=re.I|re.M|re.X)
    return match and match.group(1) or None

# 网站通过 ajax 返回脚本动态组装图片地址
# http://www.dm5.com/m114927/chapterimagefun.ashx?cid=114927&page=1&language=1&key=
def download(url):
    pat_img = r'<img[^>]+src="(.*?)"[^>]+id="cp_image"[^>]+>'
    pat_url = r'http:\/\/www\.dm5\.com\/m(\d+)-p(\d+)\/'
    pat_key = r'\|([a-z0-9A-Z]{32})\|'

    print ("  Fetching:, url")
    match = re.search(pat_url, url)
    cid = match.group(1)
    page = match.group(2) 
    key_url = 'http://www.dm5.com/m%s/chapterimagefun.ashx?cid=%s&page=%s&language=1&key=' % (cid, cid, page)
    print (key_url)
    content = requests.get(key_url, headers={'Referer': url}).text
    print (execjs.eval(content))
    print (content)
    match = re.search(pat_key, content, flags=re.I|re.M|re.X)
    key = match and match.group(1) or None
    print (cid, page, key)

def download_all(url):
    pat_url = r'http:\/\/www\.dm5\.com\/m\d+(-p\d+)?\/'
    if re.match(pat_url, url):
        print ("Fetching commics from:', url")
        content = requests.get(url).content
        page_title = get_page_title(content)
        if page_title:
            print ("  Title: , page_title")
            page_list = get_page_list(content)
            for page in page_list:
                download('http://www.dm5.com' + page)
                break
        else:
            print ("Error: commit not found!")
    else:
        print ("Not a valid dm5 url: ", url)

if __name__ == '__main__':
    OUT_DIR = 'output'
    if not os.path.exists('output'):
        os.mkdir(OUT_DIR)

    download_all('http://www.dm5.com/m114927/')
    
    if len(sys.argv) > 1:
        download_all(sys.argv[1])
    else:
        print ("Usage: crawler_dm5_com.py <url>")