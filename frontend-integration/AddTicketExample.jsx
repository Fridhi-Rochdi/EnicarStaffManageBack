// Example Create Ticket Component with Backend Integration
// Place this in your React project and adapt to your needs

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { PlusCircleIcon } from '@heroicons/react/16/solid';
import Select from 'react-select';
import { ticketsAPI, FILE_TYPES } from '../services/api';

export default function AddTicketWithBackend() {
  const [title, setTitle] = useState('');
  const [fileType, setFileType] = useState(null);
  const [totalNumber, setTotalNumber] = useState(1);
  const [description, setDescription] = useState('');
  const [file, setFile] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!title || !fileType || !totalNumber) {
      setError('Veuillez remplir tous les champs obligatoires');
      return;
    }

    setLoading(true);
    setError('');

    try {
      const ticketData = {
        title,
        description,
        fileType: fileType.value,
        totalNumber: parseInt(totalNumber),
      };

      const response = await ticketsAPI.createTicket(ticketData, file);
      
      if (response.data.success) {
        alert('Ticket créé avec succès!');
        navigate('/home');
      }
    } catch (error) {
      const message = error.response?.data?.message || 'Erreur lors de la création du ticket';
      setError(message);
    } finally {
      setLoading(false);
    }
  };

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  return (
    <React.Fragment>
      <div className="container p-2 my-2">
        <h1 className="text-2xl font-bold p-2 text-indigo-500 flex gap-2 items-center justify-center md:justify-start">
          <PlusCircleIcon className="size-6 md:size-10 " />
          Créer un Nouveau Ticket
        </h1>
      </div>

      <div className="rounded-lg bg-white p-8 shadow-lg lg:col-span-3 lg:p-12 mx-auto">
        <form onSubmit={handleSubmit} className="space-y-4">
          {error && (
            <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded">
              {error}
            </div>
          )}

          <div className="grid grid-cols-1 gap-4">
            <div>
              <label htmlFor="title" className="block text-sm font-medium text-gray-700">
                Titre : *
              </label>
              <input
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="title"
                type="text"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                required
                disabled={loading}
              />
            </div>

            <div>
              <label htmlFor="file" className="block text-sm font-medium text-gray-700">
                Fichier :
              </label>
              <input
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="file"
                type="file"
                onChange={handleFileChange}
                disabled={loading}
              />
            </div>

            <div>
              <label htmlFor="fileType" className="block text-sm font-medium text-gray-700">
                Type : *
              </label>
              <Select
                className="shadow appearance-none border rounded w-full text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="fileType"
                value={fileType}
                onChange={setFileType}
                options={FILE_TYPES}
                isDisabled={loading}
                placeholder="Sélectionnez un type"
              />
            </div>

            <div>
              <label htmlFor="totalNumber" className="block text-sm font-medium text-gray-700">
                Nombre de copies : *
              </label>
              <input
                className="shadow appearance-none border rounded w-40 py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="totalNumber"
                type="number"
                min={1}
                max={200}
                value={totalNumber}
                onChange={(e) => setTotalNumber(e.target.value)}
                required
                disabled={loading}
              />
            </div>

            <div>
              <label htmlFor="description" className="block text-sm font-medium text-gray-700">
                Note :
              </label>
              <textarea
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id="description"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                disabled={loading}
                rows={4}
              />
            </div>
          </div>

          <div className="flex justify-end">
            <button
              type="submit"
              disabled={loading}
              className="inline-block w-full rounded-lg bg-indigo-500 px-5 py-3 font-medium text-white max-w-xs hover:bg-indigo-600 disabled:bg-gray-400"
            >
              {loading ? 'Création...' : 'Créer'}
            </button>
          </div>
        </form>
      </div>
    </React.Fragment>
  );
}
