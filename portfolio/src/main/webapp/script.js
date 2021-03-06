// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', 'Woof', '你好，世界！', 'Meowwww'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}


function getPageComments() {
    const responsePromise = fetch('/list-comments');
    responsePromise.then(handleResponse);
}

function handleResponse(response) {
    const textPromise = response.json();
    textPromise.then(addPageToDom);
}

function addPageToDom(comments) {
    const pageContainer = document.getElementById('page-comments');
    comments.forEach((comment) => {
        pageContainer.appendChild(createCommentElement(comment));
    })
}

/** Creates an <h2> element */
function createHeadingElement(text) {
    const hElement = document.createElement('h2');
    hElement.innerText = text;
    return hElement;
}

/** Creates an <li> element */
function createListElement(text) {
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
}

/** Creates an element that represents a comment */
function createCommentElement(comment) {
     const commentElement = document.createElement('li');
     commentElement.className = 'comment';

     const textElement = document.createElement('span');
     textElement.innerText = comment.text;

     commentElement.appendChild(textElement);
     return commentElement;
}